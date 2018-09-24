#!/bin/sh

mill --color false mill.scalalib.PublishModule/publishAll \
        bbarker:$SONATYPE_PASSWORD \
        $GPG_PASSWORD \ 
        __.publishArtifacts \
        --release true