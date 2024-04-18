#!/bin/sh
read -p "ZK_KAFKA_LIST（eg:zkIp:zkPort/kafka）:" zkIp
read -p "副本数（单机1,集群2）:" rf
echo "begin creating queues..."
cd kafka_2.10-0.10.2.1/bin
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_BUSINESS_REQUEST --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_BUSINESS_REQUEST_INTERNAL --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_BUSINESS_RESPOND --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_ICE_TO_ICEM --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_ICEM_TO_ICE --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_ANALYSIS --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_ANALYSIS_RESULT --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_ANALYSIS_RESULT_URG --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_ANALYSIS_URG --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_FACE_DET --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_FACE_EXTRA --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_STRUCT_CAR --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_STRUCT_NONCAR --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_STRUCT_OBJECT --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_REQ_MESSAGE --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_RESP_MESSAGE --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_ANALYSIS_RESULT --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_FILE_FACE_DET --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_FILE_PERIMETER_PRECAUTION --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_FILE_STRUCT_CAR --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_FILE_STRUCT_NONCAR --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_FILE_STRUCT_OBJECT --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEO_FILE_VFD --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEOFILE_ANALYSIS --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEOFILE_ANALYSIS_RESULT --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEOFILE_ANALYSIS_RESULT_URG --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEOFILE_ANALYSIS_URG --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_VIDEOFILE_PROGRESS --replication-factor $rf --partitions 3
./kafka-topics.sh --zookeeper $zkIp --create --topic req_123456 --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic req_admin --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic req_test --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic resp_admin --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic resp_test --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic VCSS.VCDT --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic VCSS.VCMS --replication-factor $rf --partitions 1
./kafka-topics.sh --zookeeper $zkIp --create --topic t_conn_test --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic req_gateway --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic resp_gateway --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic req_videoCloud --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic resp_videoCloud --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_REQ_FIE --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_RESP_FIE --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_SYNC_FIE --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic dag_face_analysis --replication-factor $rf --partitions 6 
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_DAHUA_KAKOU --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_EFACE_PERSON_ARCHIVE_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_FACE_FEATURE_EXTRACT_TEMP --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_HIK_KAKOU --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_AC_EVENT --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_EFENCE_DETECT_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_FACE_CAP_FEATURE_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_FACE_CAPTURE_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_FEISHI_ALARM_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_GPS_REPORT_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_IDCARD_DETECT_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_MASS_EVENT_ALARM_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_PERSON_DETECT_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_SURVEILLANCE_ALARM_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_VEHICLE_DETECT_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic QUEUE_VPLUS_WIFI_DETECT_INFO --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic T_DATA_UPDATE_NOTIFY --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic T_DEVICE_UPDATE --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_PICTURE_FACE_ATTR --replication-factor $rf --partitions 6
./kafka-topics.sh --zookeeper $zkIp --create --topic Q_EFACE_SURVEIL_INFO --replication-factor $rf --partitions 1

echo "finish creating queues..."



