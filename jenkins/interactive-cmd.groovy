// paste this in your pipeline to inject custom commands interactively when it's being executed

def cmd = ''
while(true) {
  cmd = input (
    id: 'cmd', message: 'Enter a command (exit to exit)',
    parameters: [[$class: 'TextParameterDefinition', defaultValue: '', name: '']]
  )
  if(cmd == 'exit') {
    break
  } else {
    try {
      evaluate(cmd)
    } catch (e) {
      println "error: ${e}"
    }
  }
}
