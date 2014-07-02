###pre-Alpha version of dsl-command-client compiler

Used to connect with [dsl platform](dsl-platform.com) and/or/even your database (to upgrade it in unmanaged)

Provides basic functionality to generate sources and upgrade databases

call it like `runme` does

    java -jar dsl-clc-$version.jar -fdsl.props
    
dsl.props is a collection of properties, can contain:

    project-name=projectName
    username=email.you.registered@dsl-platform.com 
    password=password_chose_for_this
    project-id=<optional uuid of a project you wish to manage>
    package-name=<namespaces of your choice>
    logging-level=DEBUG
    output-path=<where the client will write generated source>
    dsl-path=<where your model definition resides at>
    migration-file=<where migration file will be outputed at>
    revenj-path=<optional path to revenj library>
    skip-diff=<true or false - should the diff be skipped if its a part of a called task>
    mono=<place where service will be deployed automaticaly> 
    db-username=<username with which to connect to the database> 
    db-password=<password with which to connect to the database>
    db-host=<database url>
    db-port=<database port>
    db-database-name=<database name>
    db-connection-string=dbconnstring
    target=<target source language>
    actions=<action to be performed>

run with `mono Revenj.Http.exe |& tee log.txt | less` at `mono`/bin location 

Check if it works at `http://<hostname>/Domain.svc/search/<some_module_name.some_root_name_at_that_module>`

[This jar was made at this place](https://github.com/ngs-doo/dsl-compiler-client)