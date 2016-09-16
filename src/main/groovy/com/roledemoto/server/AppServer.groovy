package com.roledemoto.server

import io.undertow.server.handlers.PathHandler;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Application;
import org.jboss.resteasy.plugins.servlet.ResteasyServletInitializer;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher

import io.undertow.servlet.Servlets
import io.undertow.servlet.api.DeploymentInfo
import io.undertow.servlet.api.DeploymentManager
import org.jboss.resteasy.spi.ResteasyDeployment
import org.jboss.weld.environment.servlet.Listener

import io.undertow.Undertow
import io.undertow.Handlers

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer

import java.util.logging.Logger

import static io.undertow.servlet.Servlets.listener
import static io.undertow.servlet.Servlets.servlet


/**
 *  The main class for the Undertow application server.
 */
class AppServer {



    private static final Logger logger =
        Logger.getLogger(AppServer.class.getName())


    public static void main(String[] args) {

        DeploymentInfo servletBuilder = Servlets.deployment()


        servletBuilder
                .setClassLoader(AppServer.class.getClassLoader())
                .setContextPath('/')
                .setDeploymentName('roledemoto.war')
                .addListeners(listener(Listener.class))
                .addServlets(servlet("resteasyServlet", HttpServletDispatcher)
                        .setLoadOnStartup(1)
                        .addInitParam('resteasy.injector.factory', 'org.jboss.resteasy.cdi.CdiInjectorFactory')
                        .addInitParam('javax.ws.rs.Application', JaxRsApplication.class.name)
                        // .addInitParam('resteasy.scan', '1')
                        .addMapping('/*'))


        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder)
        manager.deploy()


        PathHandler path = Handlers.path(Handlers.redirect('/')).addPrefixPath('/', manager.start())


        Undertow server = Undertow.builder().addHttpListener(9000, 'localhost').setHandler(path).build()


        server.start()




    }


}
