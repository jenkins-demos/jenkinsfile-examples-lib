#!/usr/bin/env bash
echo "running flow"
CREDS=$1
FLOWSERVER=$2
jobid=`curl -D- -u ${CREDS} \
--insecure -X POST "${FLOWSERVER}/rest/v1.0/jobs?request=runProcedure&projectName=Default&procedureName=Echo" \
-H "accept: application/json" \
-d '{"actualParameter":[{"actualParameterName":"arg1","value":"123"}]}'`
echo $jobid | grep jobId |cut -d '"' -f 4
