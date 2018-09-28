#!/bin/sh

# TODO: temporarily using a custom mill launcher:
/home/brandon/workspace/mill/out/dev/launcher/dest/run --color false api[2.12.6,jvm].publish \
  --sonatypeCreds bbarker:$SONATYPE_PASSWORD \
  --release true

#  --gpgPassphrase $GPG_PASSWORD \
