#!/usr/bin/env bash
echo "running flow"
CREDS=$1
FLOWSERVER=$2
ret=`curl -D- -u ${CREDS} \
--insecure  -X POST "${FLOWSERVER}/rest/v1.0/jobs?request=runProcedure&projectName=Default&procedureName=Echo" \
-H "accept: application/json" \
-d '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}'`
#echo $ret | grep jobId |cut -d '"' -f 4
build_id=$(echo $ret | grep jobId |cut -d '"' -f 4)
echo "$build_id"
# af300919-bd1e-11e9-ae46-02425352dfc1
pat="[a-z]|[A-Z]|[\-][0-9]"
if [[ ! "${build_id}" =~ $pat ]];
then
echo "failed"
fi