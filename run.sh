#!/bin/bash

cd src/wci/frontend/
jjtree calc.jjt
javacc calc.jj
cd ../../../
rm -r ~/NetBeansProjects/ExprParser/src/
cp -r ../../../src/ ~/NetBeansProjects/ExprParser/src/
