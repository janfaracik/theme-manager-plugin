# Theme Manager plugin for Jenkins

[![Build Status](https://ci.jenkins.io/job/Plugins/job/theme-manager-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/theme-manager-plugin/job/master/)
[![Contributors](https://img.shields.io/github/contributors/jenkinsci/theme-manager-plugin.svg)](https://github.com/jenkinsci/theme-manager-plugin/graphs/contributors)
[![Jenkins Plugin](https://img.shields.io/jenkins/plugin/v/theme-manager.svg)](https://plugins.jenkins.io/theme-manager)
[![GitHub release](https://img.shields.io/github/release/jenkinsci/theme-manager-plugin.svg?label=changelog)](https://github.com/jenkinsci/theme-manager-plugin/releases/latest)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/theme-manager.svg?color=blue)](https://plugins.jenkins.io/theme-manager)

## Introduction

Adds theme management to Jenkins, at a global or user level.

## Getting started

There's normally no need to install this plugin directly as the theme you install will depend on this.

First, you will want to install a theme plugin through the Jenkins Update Center.

### Available themes

* [Dark theme](https://github.com/jenkinsci/dark-theme-plugin)
* [Solarized theme](https://plugins.jenkins.io/solarized-theme/)
* [Material theme](https://plugins.jenkins.io/material-theme/)
* [Chocolate theme](https://plugins.jenkins.io/chocolate-theme/)
* [Catppuccin theme](https://plugins.jenkins.io/catppuccin-theme/)
* [Nord theme](https://plugins.jenkins.io/nord-theme/)

_Just send a pull request to add your theme to the list if create one_

### Configuring the plugin

You can configure this plugin globally, or each user can configure it in their configuration as well.

### Global

Manage Jenkins → Configure System → Themes

![Global configuration](docs/images/global-theme-manager.png)

You can stop users from being able to change their theme by selecting the 
'Do not allow users to select a different theme' checkbox

### User

Hover over your account icon in the top right and change your theme in the menu.

### Configuration as Code example

```yaml
appearance:
  themeManager:
    disableUserThemes: true
    theme: "noOp" # noOp is no theme, change this to the name of the theme plugin you're using, i.g. 'darkSystem'
```

## Creating a new theme

See our [developer guide](docs/developer-guide.md).

## Contributing

Refer to our [contribution guidelines](.github/CONTRIBUTING.md).

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md).
