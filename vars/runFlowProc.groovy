def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')

    def json_str = '{"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}'
    echo "found jason string  $json_str"
    def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${json_str}"
    echo "ret is $r"

}