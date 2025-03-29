(function () {
  // const themeJson = document.getElementById('theme-manager-theme').text
  // const theme = JSON.parse(themeJson);

  // console.log(theme)

  // if (theme.id && theme.id !== '') {
  //   document.documentElement.dataset.theme = theme.id
  // }


  const themes = {
    lightTheme: "light",
    darkTheme: "dark",
  }

  const darkThemeMq = window.matchMedia("(prefers-color-scheme: dark)");
  darkThemeMq.addEventListener("change",e => {
    if (e.matches) {
      document.documentElement.dataset.theme = themes.darkTheme;
    } else {
      document.documentElement.dataset.theme = themes.lightTheme;
    }
  });
  darkThemeMq.dispatchEvent(new Event("change"));

  // window.isSystemRespectingTheme = theme.respect_system_appearance
  //
  // const propertiesJson = document.getElementById('theme-manager-properties')
  // may not be present, e.g. on BlueOcean where the theme is not marked as BlueOcean compatible
  // if (propertiesJson) {
  //   const parsedProperties = JSON.parse(propertiesJson.text);
  //
  //   window.getThemeManagerProperty = function (plugin, propertyName) {
  //     const isDark = window.matchMedia('(prefers-color-scheme: dark)').matches
  //
  //     let propertyNameNormalised = propertyName
  //     if (isSystemRespectingTheme) {
  //       propertyNameNormalised = isDark ? `${propertyName}-dark` : `${propertyName}-light`
  //     }
  //     return parsedProperties[`${plugin}:${propertyNameNormalised}`]
  //   }
  // }
})()
