# RestEasy + Undertow + MongoDB

This is a demo server using the JBoss Undertow microserver, together with RestEasy and CDI bean injection.

The main application class is the `AppServer` and this will start the Undertow server instance.
There's also a standard configuration for a Mongo data manager, and some POST and GET resources to
create and read objects of `User` type.
