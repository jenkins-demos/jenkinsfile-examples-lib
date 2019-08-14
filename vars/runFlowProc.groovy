def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    echo 'curl options are in script ${config.curlOptions}'
    //def json_str = '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}'
    //echo "found jason string  $json_str"
    def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${config.jsonArgs} ${config.procName} ${config.projName} ${config.curlOptions}"
    echo "ret is $r"

}