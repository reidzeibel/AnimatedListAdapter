AnimatedListAdapter
===================

An android library that makes it easy to create an animated expand-collapse list using RecyclerView

Code was taken from [Nick Butcher's Plaid App](https://github.com/nickbutcher/plaid), I just separated the code into a BaseAnimatedListAdapter so it is easier to use.

Video from Google I/O 2016 : https://www.youtube.com/watch?v=EjTJIDKT72M (example of the animation starts at [5:24](https://youtu.be/EjTJIDKT72M?t=324))

*Requires API v19

Download
--------

Download latest [aar](https://dl.bintray.com/reidzeibel/maven/com/reidzeibel/animatedlistadapter/animated-list-adapter/0.2/:animated-list-adapter-0.2.aar), or grab via Maven:
```xml
<dependency>
  <groupId>com.reidzeibel.animatedlistadapter</groupId>
  <artifactId>animated-list-adapter</artifactId>
  <version>0.2</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```groovy
compile 'com.reidzeibel.animatedlistadapter:animated-list-adapter:0.2'
```

Library is distributed via JCenter


Example Usage
-------------

I'm using [butterknife](http://jakewharton.github.io/butterknife/)

Note : will add sample app to the library

```java
// Create a RecylcerView Adapter that extends BaseAnimatedListAdapter
public class TestAdapter extends BaseAnimatedListAdapter<TestAdapter.TestHolder> {

    // Your ViewHolder here 
    static class TestHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.test) TextView testview;

        TestHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    // Pass the recyclerView to the adapter using the constructor, then call initAnimatedListAdapter()
    public TestAdapter(RecyclerView recyclerView) {
        setRecyclerView(recyclerView);
        initAnimatedListAdapter();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        final TestHolder holder = new TestHolder(v);
        
        //add this line
        setClickListener(holder);
        
        return holder;
    }

    @Override
    public void onBindViewHolder(TestAdapter.TestHolder holder, int position) {
        
        final boolean isExpanded = position == mExpandedPosition;
        
        // expands the selected item if it is collapsed, and also collapse the previously expanded view.
        holder.itemView.setActivated(isExpanded);
        holder.testview.setVisibility(isExpanded? View.VISIBLE : View.GONE);
        
    }
}
```

License
-------

    Copyright 2017 Ridwan Aditama (reidzeibel)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
