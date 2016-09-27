## UpdateableActivity

The requirement is to pass a set of items to an activity that is responsible for displaying the items so that the user can choose from them and have the activity return the result to the querying activity.

However after launching the select activity with items from a cache, the querying activity is also required to request updated data and when that asynchronous call returns pass the fresh set of items to the existing activity.

For normal startActivity invocations a launch mode such as singleTop works fine but when invoking startActivityForResult a second instance is created instead of onNewIntent being invoked. Using broadcast works with both startActivity and startActivityForResult.

## License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.