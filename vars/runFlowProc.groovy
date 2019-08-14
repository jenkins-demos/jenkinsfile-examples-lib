def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    def r = sh label: 'runFlowProc.sh', returnStdout: true, script: "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${config.jsonArgs} ${config.procName} ${config.projName} ${config.curlOptions}"
    return r


}