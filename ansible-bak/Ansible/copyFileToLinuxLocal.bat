
pscp -pw 123 ansible-dev\*.yml root@192.168.0.108:/opt/ansible/ansible-dev
pscp -pw 123 ansible-dev\*.ini root@192.168.0.108:/opt/ansible/ansible-dev
REM pscp -pw 123 -r ansible-dev\group_vars\* root@192.168.0.108:/opt/ansible/ansible-dev/group_vars
pscp -pw 123 -r ansible-dev\roles\* root@192.168.0.108:/opt/ansible/ansible-dev/roles
pscp -pw 123 shell\*.sh root@192.168.0.108:/opt/ansible

pause
