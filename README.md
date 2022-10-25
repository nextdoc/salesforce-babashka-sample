# Salesforce DX Babashka Example Project

## What is this?

This is a Salesforce *source tracked* project that shows how to create automation scripts for the 2 CLI tools provided by Salesforce. The included script demostrates:
- a sequence of CLI calls
    - create scratch org
    - install package from appexchange
    - deploy source
    - open org in browser
- custom CLI arguments (see create org step using -parse-args)
- all tasks are checked for successful exit code from the CLI
- most tasks are blocking but the package install polls for success before completion
- tasks are sequenced using dependencies (similar to makefiles)
- tasks can use data from previous tasks

The scripts are written in Clojure using the [Babashka tasks](https://book.babashka.org/#tasks) feature so they start as fast as other scripting languages. Babashka is portable i.e. runs on Windows, Mac and Linux.

This project was created using the command `sfdx force:project:create --projectname salesforce-babashka-sample`

Then the sample bb.edn file was added to provide DX scripting using functions from https://github.com/nextdoc/salesforce-babashka and that's it. It should be the same for you.

## How to use this?

You will need to [install Babashka](https://book.babashka.org/#_installation)

Then you can either:
1. clone this repo
2. copy the bb.edn from here into your own repo 

Once you have a [bb.edn](https://github.com/nextdoc/salesforce-babashka-sample/blob/master/bb.edn) file, 
in the terminal you can try `bb tasks` to see what is available

Then try `bb nxd:scratch-org-list` to run a read-only task. Look at the [bb.edn](https://github.com/nextdoc/salesforce-babashka-sample/blob/master/bb.edn) to see how it works.

There is another task named *nxd:create-and-open-org* which will run a sequence of CLI steps to create, deploy and open a new scratch org.

This is the best example of the power of using Babashka in this environment. 
It demonstrates task dependencies (similar to makefiles.)

## Why use this?

TODO blog post link

## How can you help?

If your company uses these tools, please consider [sponsoring the author](https://github.com/sponsors/borkdude) of Babashka.