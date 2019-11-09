

## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
  * [packages](#PL_Fixture_packages)
  * [Installition](#installation)

# about-the-project
It is an *English Premier League* sample app which will let you follow its daily matches, you also can add the fixture to your favorites so you can show them only.

# screenshots
<img src="https://github.com/siifii/PLFixture/blob/master/readme_screenshot/Screenshot_1573324014.png"/>
<img src="https://github.com/siifii/PLFixture/blob/master/readme_screenshot/Screenshot_1573324018.png"/>

# PL-Fixture-packages:
1. **data**: It has all the local and remote data classes.
2. **di**: Dependency providing and modules.
3. **ui**: View classes with its viewModels.
4. **utils**: Utility classes.

# built-with
I am using MVVM  pattern, MVVM enforces a clear separation between Views and their master - ViewModel, as the latter holds no reference to Views. 
* Kotlin Language
* [Android architecture component](https://developer.android.com/jetpack/docs/guide)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Data binding](https://developer.android.com/topic/libraries/data-binding/)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Room](https://developer.android.com/topic/libraries/architecture/room)
* [RxJava2](https://github.com/ReactiveX/RxJava)
* [KOIN](https://insert-koin.io/)
* [Anko](https://github.com/Kotlin/anko)
* [Retrofit](https://square.github.io/retrofit/)
* [jUnit](https://developer.android.com/training/testing/unit-testing/local-unit-tests)


## Installation
First you should get your own [Api-key](https://www.football-data.org/client/register)
After that you have to create your own ```credentials.properties```  file then add you key as that  ```API_KEY=“YOUR_API_KEY” ```
