#!/bin/sh

################################
# 创建es索引
################################

# index_list=(vfd_inspection_record_indice \
# vfd_inspection_record_indice \
# vfd_inspection_record_province_indice \
# vfd_inspection_record_province_indice \
# vfd_inspection_testdata_record_indice \
# vfd_inspection_testdata_record_indice \
# vfd_inspection_testdata_record_province_indice \
# vfd_inspection_testdata_record_province_indice \
# sampling_vfd_inspection_record_indice \
# sampling_vfd_inspection_record_indice \
# sampling_vfd_inspection_record_province_indice \
# sampling_vfd_inspection_record_province_indice \
# important_video_share_indice \
# important_video_share_indice \
# preferential_video_share_indice \
# preferential_video_share_indice \
# vfd_inspection_record_stream_record_indice \
# vfd_inspection_record_stream_record_indice \
# vfd_inspection_record_stream_record_province_indice \
# vfd_inspection_record_stream_record_province_indice \
# vfd_inspection_testdata_record_stream_record_indice \
# vfd_inspection_testdata_record_stream_record_indice \
# vfd_inspection_testdata_record_stream_record_province_indice \
# vfd_inspection_testdata_record_stream_record_province_indice \
# sampling_vfd_inspection_record_stream_record_indice \
# sampling_vfd_inspection_record_stream_record_indice \
# sampling_vfd_inspection_record_stream_record_province_indice \
# sampling_vfd_inspection_record_stream_record_province_indice)

index_list=(i_test_aaa \
i_test_bbb)


# curl -XPUT 172.25.21.29:9200/i_testcreate002 -d '{"settings":{"number_of_shards":5,"number_of_replicas":1}}'
# curl -XPUT 172.25.21.29:9200/i_testcreate002 -d '{"settings":{"index":{"number_of_shards":5,"number_of_replicas":1}}}'

for var in ${index_list[@]};
do
	echo "172.25.21.29:9200/$var -d '{"settings":{"index":{"number_of_shards":5,"number_of_replicas":1}}}'"
	curl -XPUT 172.25.21.29:9200/$var -d '{"settings":{"index":{"number_of_shards":5,"number_of_replicas":1}}}'
	echo ""
	echo ""
done

