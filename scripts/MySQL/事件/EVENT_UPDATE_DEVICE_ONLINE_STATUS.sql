# 每5分钟调用一次存储过程

drop EVENT if EXISTS EVENT_UPDATE_DEVICE_ONLINE_STATUS;
DELIMITER //
CREATE EVENT `EVENT_UPDATE_DEVICE_ONLINE_STATUS` 
ON SCHEDULE EVERY 5 MINUTE STARTS '2022-05-08 00:00:00' 
ON COMPLETION NOT PRESERVE ENABLE  
DO 
BEGIN
call SP_UPDATE_DEVICE_ONLINE_STATUS();
END//
DELIMITER ;