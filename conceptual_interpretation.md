# Conceptual Interpretation

This chapter will introduce you our main features and concepts, you will learn how to write a plugin with friendly experience. Wish you have a pleasant journey.

## Action

An **action** means a feature or function, it consists of [keywords](#action-keyword) and [handler](#action-handler), app will find the corresponding **action** through the user entered keyword, then call Action's handler, handler will return a result list to our for rendering on [Action Window](#action-window).

## Action Window

Action Window is the main window of our app. **Action window** is responsible for rendering the pinned [keywords](#action-keyword), toolbars, Action Window pinned states, display notification of the result execution state, [text of user input](#action-input-field), list of the [Action Result](#action-result) and [Action Result Callbacks](#action-result-callback).

## Action Input Field

Action Input Field is a text field, it's work is to get the content what user typed and render the logo which user pinned keyword. It also is part of the [**action window**](#action-window).

## Action Keyword

Action Keyword means the keywords of the [**action**](#action), we also call it keyword or keywords, and we require the keyword can't exceed 32 characters. An **action** can have multiple keywords.

## Action Handler

In **action handler** (we also call it handler), your logic code will be here, we will pass the parsed keyword and parameter that user input to your handler, you need to process our query request and return results.

## Action Result

Action Result is what your handler returns, it's core fields include score, logo, title, subtitle, callbacks and result (the real computed result).

> [Action Result Fields Explanation](appendix/action_result.md#action-result-fields-explanation)

## Action Result Callback

Action Result Callback refers the specific execution method of the result, for example copy it, or open it or any others. Callbacks are also part of the action result.

> [Action Result Callback Fields Explanation](appendix/action_result_callback.md#action-result-callback-fields-explanation)

## Func Page

Func page is your customized ui, it can open as a pinned keyword, if the functions you want to provide require interact with graphics user interface, you need this feature, and this feature only available in [jar plugin](jar-plugin-guide/jar_guide.md#jar-plugin-guide). If you familiar with any JVM programming language, you can read [this section](jar-plugin-guide/func_page.md#func-page) to learn more about how to write a func page.

## What's Next

[**Follow our tutorial to write a general fully functional plugin**](general-plugin-guide/general_guide.md#general-plugin-guide). Or [**write a jar plugin**](jar-plugin-guide/jar_guide.md#jar-plugin-guide).
