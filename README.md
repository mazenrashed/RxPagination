
# RxPagination

![](https://jitpack.io/v/mazenrashed/DotsIndicatorWithoutViewpager.svg)

Implement pagination in a few lines

![](https://media.giphy.com/media/dUs6RgepqKTR0UrEkl/giphy.gif)
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
    implementation 'com.github.mazenrashed:DotsIndicatorWithoutViewpager:${LAST_VERSION}'
}
```
# Usage
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
	    
    }  
  
    override fun onFetchDataListError(throwable: Throwable) {  
    
    }  
  
    override fun onFetchDataListSuccess(dataList: ArrayList<GithubRepository>) {  
    
    }
 }
```
## In the UI (Activity or Fragment)
```kotlin
viewModel  
  .dataList  
  .observeOn(AndroidSchedulers.mainThread())  
  .subscribe { dataList ->  
	// Adpate your list adapter here 
    }
```
## Load and reload data
```kotlin
viewModel.loadDataList() //To load the data at the first time

viewModel.reloadDataList() //To reload the data
```

## Contributing

We welcome contributions !
* ⇄ Pull requests and ★ Stars are always welcome.
