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

#if [[ "${build_id}" =~ [^a-zA-Z0-9\ ] ]];

#then BLAH; fi