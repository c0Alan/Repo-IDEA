
pscp -pw Suntek123 ansible-dev\*.yml root@172.25.20.151:/opt/dev/ansible/ansible-dev
pscp -pw Suntek123 ansible-dev\*.ini root@172.25.20.151:/opt/dev/ansible/ansible-dev
pscp -pw Suntek123 -r ansible-dev\group_vars\* root@172.25.20.151:/opt/dev/ansible/ansible-dev/group_vars
pscp -pw Suntek123 -r ansible-dev\roles\* root@172.25.20.151:/opt/dev/ansible/ansible-dev/roles
pscp -pw Suntek123 shell\*.sh root@172.25.20.151:/opt/dev/ansible

pause
