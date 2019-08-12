def call(Map config) {
    loadLinuxScript(name: 'runFlowProc.sh')

    foo=$(cat <<EOF
            {"actualParameter":[{"actualParameterName":"arg1","value":"1234567"}]}
            EOF
    )

    def r = sh "./runFlowProc.sh ${config.flowCreds} ${config.flowServer} ${foo}"
    echo "ret is $r"

}