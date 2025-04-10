#!/bin/bash
# Compila todos os arquivos .java recursivamente
find . -name "*.java" > sources.txt
javac @sources.txt
