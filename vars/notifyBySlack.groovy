def call(String buildStatus = 'STARTED', String message) {
  // Build status of null means successful.
    buildStatus = buildStatus ?: 'SUCCESS:success-status:'
    // Replace encoded slashes.
    def decodedJobName = env.JOB_NAME.replaceAll("%2F", "/")

    def colorSlack

    if (buildStatus == 'STARTED') {
        colorSlack = '#D4DADF'
        buildStatus+=":starttask:"
    } else if (buildStatus == 'SUCCESS') {
        colorSlack = '#BDFFC3'
        buildStatus+=":success-status:"
    } else if (buildStatus == 'UNSTABLE') {
        colorSlack = '#FFFE89'
        buildStatus+=":unstable:"
    } else {
        colorSlack = '#FF9FA1'
        buildStatus+=":failed-status:"
    }

    def msgSlack = "${buildStatus}: `${decodedJobName}` #${env.BUILD_NUMBER}: (<${env.BUILD_URL}|Open>) ${message}"

    slackSend(color: colorSlack, message: msgSlack)
}
