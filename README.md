
# RxPagination

[![](https://jitpack.io/v/mazenrashed/RxPagination.svg)](https://jitpack.io/#mazenrashed/RxPagination)

Implement the pagination in a few lines, 

![](https://media.giphy.com/media/RN2oZPyBkUKQbi1WD1/giphy.gif)
###  Add the JitPack repository to your build file
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
### Add dependency
```groovy
dependencies {
    implementation 'com.github.mazenrashed:RxPagination:${LAST_VERSION}'
}
```
# Usage
We will use the car example,
## In Your repository
Jest implement ListRepository\<T\>
```kotlin
class CarRepository : ListRepository<Car>{
...
}
```

Then, you need to override getDataList(page: Int, pageSize : Int) inside the repository
```kotlin
class CarRepository : ListRepository<Car> {  
  
    override fun getDataList(page: Int, pageSize : Int): Single<ArrayList<Car>> {  
        return endPoints.getCars(pageSize, page) //For Example (You need to return your data source here)
    }  
      
}
```

## In The View Model
Inehet from RxPagination\<T\>
```kotlin
class CarsViewModel(carsRepository: CarRepository) :  
    RxPagination<CarRepository>(carsRepository, PAGE_SIZE, FIRST_PAGE) {  
      
    init {  
        loadDataList()  
    }
    
 }
```
Then, you need to override onFetchDataListSubscribed,
onFetchDataListError and onFetchDataListSuccess
```kotlin
class CarsViewModel(carsRepository: CarRepository) :  
    RxPagination<CarRepository>(carsRepository, PAGE_SIZE, FIRST_PAGE) {  
      
    init {  
        loadDataList()  
    }
    
    override fun onFetchDataListSubscribed() {  
	   //Start fetching data
    }  
  
    override fun onFetchDataListError(throwable: Throwable) {  
	   
    }  
  
    override fun onFetchDataListSuccess(lastLoadedList: ArrayList<GithubRepository>) {  
	  //You don't need to handle the data, but if you need it, it's available
	  //This lastLoadedList is the new loaded part.
    }
 }
```
## In the UI (Activity or Fragment)
To observe the data list, use viewModel.dataList, 
dataList is a BehaviorRelay\<ArrayList\<T\>\>
```kotlin
viewModel  
  .dataList  
  .observeOn(AndroidSchedulers.mainThread())  
  .subscribe { dataList ->  
	// notify your list adapter here 
    }
```
## Load and reload data
```kotlin
viewModel.loadDataList() //To load the more data

viewModel.reloadDataList() //To reload the data
```

## Contributing

We welcome contributions !
* ⇄ Pull requests and ★ Stars are always welcome.
