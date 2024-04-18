https://www.cnblogs.com/jsonhc/p/7895399.html
ansible-playbook copy_configfile.yml
ansible all -m setup -a "filter=ansible_hostname"
ansible SERVER79 -m setup