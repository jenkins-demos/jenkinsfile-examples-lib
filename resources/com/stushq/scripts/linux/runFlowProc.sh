#!/usr/bin/env bash
CREDS=$1
FLOWSERVER=$2



generate_post_data()
{
cat <<EOF
{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}
EOF
}


fg="**$(generate_post_data)**"
echo "fg is${fg}"

ret=`curl -D- -u ${CREDS} \
--insecure  -vvvv -X POST "${FLOWSERVER}/rest/v1.0/jobs?request=runProcedure&projectName=Default&procedureName=Echo" \
-H "accept: application/json" \
--data "$(generate_post_data)"`
#-d '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}'`

# --data "$(generate_post_data)"`



# -d '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}'`


# -d '$DAT'`

job_id=$(echo $ret | grep jobId |cut -d '"' -f 4)
#echo "$job_id"


pat="[a-z]|[A-Z]|[\-][0-9]"
if [[ ! "${job_id}" =~ $pat ]];
then
  echo "Failed calling flow proceedure, no job id available "
  exit 1
else
  echo "Job id = ${job_id}"
  exit 0
fi
