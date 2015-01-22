#!/usr/bin/env bash

lein marg -m -d _site
mv _site/toc.html _site/index.html
sed -i 's/toc.html/index.html/' _site/*

cd _site
git add .
git commit -m 'updated docs'
git push origin gh-pages

cd ..
git commit -a -m 'build site'
git push origin master
