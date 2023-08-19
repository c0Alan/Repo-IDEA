drop PROCEDURE if EXISTS SP_UPDATE_DEVICE_ONLINE_STATUS;
DELIMITER //
CREATE procedure SP_UPDATE_DEVICE_ONLINE_STATUS()
begin
		UPDATE omof_camera_info,videoweb_dw.videopointinfo
SET omof_camera_info.IS_ONLINE = videoweb_dw.videopointinfo.ISUSED
where omof_camera_info.SBBM = videoweb_dw.videopointinfo.VIDEOFLAG AND 
videoweb_dw.videopointinfo.DELETE_STATUS=0 and omof_camera_info.IS_DELETE=1;
	
end//
DELIMITER ;
