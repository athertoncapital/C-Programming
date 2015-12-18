#ifndef LINKEDLIST_H
#define LINKEDLIST_H

/**
 * @file
 * This file provided a doubly-linked list implementation capable of storing any arbitrary data.
 * The list implementation relies on a chain metaphor: a list is merely a sequence of links
 * (ListItems) and there is no separate construct to represent the entire list, each ListItem in it
 * does that implicitly.
 * ListItems can hold any data, or even none (indicated by a NULL pointer), and so the Sort() and
 * Print() functions are entirely generic, relying on additional user-created functions that know
 * the type of data stored in the ListItems for doing the real work.
 */

/**
 * This is the struct that will hold an individual list item. This is a doubly-linked list and
 * so there is no need to have a separate list struct that holds all of the individual list items
 * as they're already chained together. Note that the data is a (void *), which means that it can
 * hold any type of pointer, even pointers to multi-dimensional arrays. This also means that any
 * data stored in a list item must first be allocated.
 */
typedef struct ListItem {
  struct ListItem *previousItem;
  struct ListItem *nextItem;
  void *data;
} ListItem;


/**
 * This function starts a new linked list. Given an allocated pointer to data it will return a
 * pointer for a malloc()ed ListItem struct. If malloc() fails for any reason, then this function
 * returns NULL otherwise it should return a pointer to this new list item. data can be NULL.
 *
 * @param data The data to be stored in the first ListItem in this new list. Can be any valid 
 *             pointer value.
 * @return A pointer to the malloc()'d ListItem. May be NULL if an error occured.
 */
ListItem *NewList(void *data);

/**
 * This function will remove a list item from the linked list and free() the memory that the
 * ListItem struct was using. It doesn't, however, free() the data pointer and instead returns it
 * so that the calling code can manage it.  If passed a pointer to NULL, Remove() should return
 * NULL to signal an error.
 *
 * @param item The ListItem to remove from the list.
 * @return The data pointer from the removed item. May be NULL.
 */
void *Remove(ListItem *item);

/**
 * This function returns the total size of the linked list. This means that even if it is passed a
 * ListItem that is not at the head of the list, it should still return the total number of
 * ListItems in the list.
 *
 * @param list An item in the list to be sized.
 * @return The number of ListItems in the list (0 if `list` was NULL).
 */
int Size(ListItem *list);

/**
 * This function returns the head of a list given some element in the list. If it is passed NULL,
 * it will just return NULL. If given the head of the list it will just return the pointer to the
 * head anyways for consistency.
 *
 * @param list An element in a list.
 * @return The first element in the list. Or NULL if provided an invalid list.
 */
ListItem *GetFirst(ListItem *list);

/**
 * This function allocates a new ListItem containing data and inserts it into the list directly
 * after item. It rearranges the pointers of other elements in the list to make this happen. If
 * passed a NULL item, InsertAfter() should still create a new ListItem, just with no previousItem.
 * It returns NULL if it can't malloc() a new ListItem, otherwise it returns a pointer to the new
 * item. The data parameter is also allowed to be NULL.
 *
 * @param item The ListItem that will be before the newly-created ListItem.
 * @param data The data the new ListItem will point to.
 * @return A pointer to the newly-malloc()'d ListItem.
 */
ListItem *InsertAfter(ListItem *item, void *data);

/**
 * SwapData() switches the data pointers of two ListItems. This is most useful when trying to
 * reorder ListItems but when you want to preserve their location. It is used within Sort() for
 * swapping items, but probably isn't too useful otherwise. This function should return
 * STANDARD_ERROR if passed a pointer to NULL, otherwise it should return SUCCESS.  Also, it is good
 * to note that SwapData() should be able to swap data pointers that point to NULL.
 *
 * @param firstItem One of the items whose data will be swapped.
 * @param secondItem Another item whose data will be swapped.
 * @return SUCCESS if the swap worked or STANDARD_ERROR if it failed.
 */
int SwapData(ListItem *firstItem, ListItem *secondItem);

/**
 * Sort() performs a selection sort on list to sort the elements into decending order. It makes no
 * guarantees of the addresses of the list items after sorting, so any ListItem referenced before a
 * call to Sort() and after may contain different data. Its second argument is a comparison function
 * that calculates the ordering. This function takes two const ListItem pointers and returns 1 if
 * the first one is "larger", 0 if they're "equal", and -1 if the second one is "bigger". Since
 * sorting relies on understanding the data within the ListItem, the comparison function is left up
 * to the caller to define. This comparison function follows the same return types as the one used
 * for qsort(). See qsort()'s  documentation for further information. For consistency Sort() returns
 * SUCCESS if successful. If passed a NULL pointer for either argument, it will do nothing and
 * return STANDARD_ERROR.
 *
 * @param list Any element in the list to sort.
 * @param CompareItems A function that can do a <, =, > sort between two items in `list`.
 * @return SUCCESS if successful or STANDARD_ERROR is passed NULL pointers.
 */
int Sort(ListItem *list, int (*CompareItems)(const ListItem *, const ListItem *));

/**
 * Print() prints out the complete list to stdout. Like Sort() it relies on a function pointer as
 * its second argument. In this case the passed function prints an individual ListItem along with
 * any delimiters. The passed PrintItem function needs to add a two-character delimiter to the
 * output. The delimiters are then removed after the last item using two \b characters. The entire
 * list is surrounded by square brackets on output. An example for the printout of a list of ints is
 * "[1, 5, 2, 10, 9]". If Print() is called with a NULL list or a NULL function pointer, Print()
 * does nothing and returns STANDARD_ERROR, and will otherwise return SUCCESS.
 *
 * @param list Any element in the list to print.
 * @param PrintItem A function that can print one of the list items to stdout.
 * @return SUCCESS or STANDARD_ERROR if passed NULL pointers.
 */
int Print(ListItem *list, void (*PrintItem)(const ListItem *));

#endif
