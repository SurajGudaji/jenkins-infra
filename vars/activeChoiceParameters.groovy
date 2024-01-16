def activeChoiceParameters = [
    $class: 'ChoiceParameter',
    choiceType: 'PT_SINGLE_SELECT',
    description: 'Select a query option',
    filterLength: 1,
    filterable: false,
    name: 'QueryOption',
    randomName: 'QueryOption',
    script: [
        $class: 'GroovyScript',
        fallbackScript: [
            classpath: [],
            sandbox: false,
            script: 'return ["Error"]'
        ],
        script: [
            classpath: [],
            sandbox: false,
            script: 'return ["1" : "Check Node Crash", "2" : "Brief Job information", "3" : "Detailed Job information", "4" : "Failed testcases"]'
        ]
    ]
]

return activeChoiceParameters