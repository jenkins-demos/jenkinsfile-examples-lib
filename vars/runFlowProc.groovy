def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')
    sh "./runFlowProc.sh"
}