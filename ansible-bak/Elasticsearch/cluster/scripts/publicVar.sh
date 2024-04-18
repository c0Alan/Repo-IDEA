home=/opt/dev/elasticsearch
package=elasticsearch-7.3.0-linux-x86_64.tar.gz
packageDir=elasticsearch-7.3.0
downloadUrl=https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.3.0-linux-x86_64.tar.gz

clusterName=esCluster
nodeName=node-1
nodeMaster=true
nodeData=true
localIp=192.168.170.130
httpPort=9200
transportTcpPort=9300
seed_hosts=[\"192.168.170.130\",\"192.168.170.129\"]
initial_master_nodes=[\"192.168.170.130\"]
httpCorsEnabled=true
httpCorsAllowOrigin='"*"'
