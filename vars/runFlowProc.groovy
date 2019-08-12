def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    def proc ='./runFlowProc.sh ${config.flowCreds} ${config.flowServer}'.execute()
    //def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer}"
    //echo "ret is $r"

}