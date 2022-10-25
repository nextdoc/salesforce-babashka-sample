# Salesforce DX Babashka Example Project

This project was created using the command `sfdx force:project:create --projectname salesforce-babashka-sample`

Then a bb.edn file was added to provide DX scripting using tasks from https://github.com/nextdoc/salesforce-babashka

# How to use this?

You will need to install Babashka https://book.babashka.org/#_installation

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