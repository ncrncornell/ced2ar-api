#!/bin/sh

mill --color false api[2.12.6].publish \
  --sonatypeCreds bbarker:$SONATYPE_PASSWORD \
  --gpgPassphrase $GPG_PASSWORD \
  --release true

# mill --color false mill.scalalib.PublishModule/publishAll \
#         bbarker:$SONATYPE_PASSWORD \
#         $GPG_PASSWORD \ 
#         __.publishArtifacts \
#         --release true
