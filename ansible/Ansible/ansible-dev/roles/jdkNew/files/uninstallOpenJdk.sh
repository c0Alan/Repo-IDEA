#!/bin/bash
# 卸载open jdk

/usr/bin/expect << EOF
spawn yum remove *openjdk*
expect {
	"y/N]:" { send "y\n" }
}
interact
expect eof
EOF

exit 0