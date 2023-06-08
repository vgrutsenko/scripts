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
