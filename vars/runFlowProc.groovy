def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer}"
    echo "ret is $r"
    
}