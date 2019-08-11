#!/usr/bin/env bash
echo "running flow"
CREDS=$1
FLOWSERVER=$2
ret=`curl -D- -u ${CREDS} \
--insecure -vvv -X POST "${FLOWSERVER}/rest/v1.0/jobs?request=runProcedure&projectName=Default&procedureName=Echo" \
-H "accept: application/json" \
-d '{"actualParameter":[{"actualParameterName":"arg12","value":"1234567"}]}'`
$build_id=$(echo $ret | grep jobId |cut -d '"' -f 4)