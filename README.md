## UpdateableActivity

The requirement is to pass a set of items to an activity that is responsible for displaying the items so that the user can choose from them and have the activity return the result to the querying activity.

However after launching the select activity with items from a cache, the querying activity is also required to request updated data and when that asynchronous call returns pass the fresh set of items to the existing activity.

For normal startActivity invocations a launch mode such as singleTop works fine but when invoking startActivityForResult a second instance is created instead of onNewIntent being invoked. Using broadcast works with both startActivity and startActivityForResult.