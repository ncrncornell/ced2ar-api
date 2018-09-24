#!/bin/sh

mill api.publish  --sonatypeCreds bbarker:$SONATYPE_PASSWORD \
  --gpgPassphrase $GPG_PASSWORD \
  --release true

# mill --color false mill.scalalib.PublishModule/publishAll \
#         bbarker:$SONATYPE_PASSWORD \
#         $GPG_PASSWORD \ 
#         __.publishArtifacts \
#         --release true