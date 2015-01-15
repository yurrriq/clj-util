#!/usr/bin/env bash

lein marg -m && \
mv docs/toc.html docs/index.html && \
sed -i 's/toc.html/index.html/' docs/*
