- https://github.com/antonpichka/library_architecture_mvvm_modify/tree/main/package#architectural-objects
- https://github.com/antonpichka/library_architecture_mvvm_modify/labels

---

- After setup. Everything after this message can be deleted. Even the message itself

## Project setup

- [android_template_for_lamm_kotlin](https://github.com/antonpichka/template_for_lamm_kotlin#android_template_for_lamm_kotlin)

### android_template_for_lamm_kotlin

- If you need to change the application name from 'android_template_for_lamm_kotlin' to 'android_${your_name}':
- - 'android_template_for_lamm_kotlin/settings.gradle.kts':
- - - 'rootProject.name = "android_template_for_lamm_kotlin"' to 'rootProject.name = "android_${your_name}"'
- - 'android_template_for_lamm_kotlin/app/build.gradle.kts':
- - - 'namespace = "com.android_template_for_lamm_kotlin"' to 'namespace = "com.android_${your_name}"'
- - - 'applicationId = "com.android_template_for_lamm_kotlin"' to 'applicationId = "com.android_${your_name}"'
- - 'android_template_for_lamm_kotlin/app/src/main/res/values/strings.xml':
- - - '<string name="app_name">AndroidTemplateForLAMMKotlin</string>' to '<string name="app_name">${your_name}</string>'
- - 'android_template_for_lamm_kotlin/app/src/main/java/com/android_template_for_lamm_kotlin' to 'android_template_for_lamm_kotlin/app/src/main/java/com/android_${your_name}'