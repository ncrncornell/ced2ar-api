#!/bin/sh

mill --color false api[2.12.6].publish \
  --sonatypeCreds bbarker:$SONATYPE_PASSWORD \
  --release true

#  --gpgPassphrase $GPG_PASSWORD \
