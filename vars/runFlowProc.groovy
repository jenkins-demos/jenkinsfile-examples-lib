def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    //def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${config.jsonArgs} ${config.procName} ${config.projName} ${config.curlOptions}"
    //echo "ret is $r"


    def r = sh label: '', returnStdout: true, script: "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${config.jsonArgs} ${config.procName} ${config.projName} ${config.curlOptions}"
    echo r
    retun r


}