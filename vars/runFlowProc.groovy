def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${config.jsonArgs} ${config.procName} ${config.projName} ${config.curlOptions}"
    echo "ret is $r"

}