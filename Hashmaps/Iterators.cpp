#include<iostream>
#include<unordered_map>
#include<vector>
#include<string>
using namespace std;

int main(){
    unordered_map<string, int> map;
    map["abc"] = 10;
    map["abc1"] = 20;
    map["abc2"] = 30;
    map["abc3"] = 40;
    map["abc4"] = 50;
    map["abc5"] = 60;

    // Iterators in unordered_map
    unordered_map<string, int>::iterator it = map.begin();

    while(it != map.end()){
        cout << "Key: " << it->first << ", Value: " << it->second << endl;
        it++;
    }

    // find 
    unordered_map<string, int>::iterator ite = map.find("abc5");
    map.erase(ite);
    
    if(map.count("abc5")) cout << map.at("abc5") << endl;
    else cout << "abc5 values is removed" << endl;

    
    vector<int> vt;
    vt.push_back(1);
    vt.push_back(2);
    vt.push_back(3);
    vt.push_back(4);
    vt.push_back(5);
    vt.push_back(6);
    // Iterators in Vectors
    vector<int>::iterator it2 = vt.begin();
    cout << "Vector Elements: ";
    while(it2 != vt.end()){
        cout << *it2 << " ";
        it2++;
    }

    return 0;
}